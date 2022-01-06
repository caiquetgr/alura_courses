package main

import (
	"bufio"
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"os"
	"strconv"
	"strings"
	"time"
)

const monitoringLoopTimes = 3
const monitoringTimeDelay = 3
const monitoringTimeType = time.Second

const logFileName = "log.txt"

func main() {

	showIntroduction()

	for {
		showMenu()
		command := readCommand()

		switch command {
		case 1:
			startMonitoring()
		case 2:
			printLogs()
		case 0:
			fmt.Println("Bye bye!")
			os.Exit(0)
		default:
			fmt.Println("Unknown command")
			os.Exit(-1)
		}
	}
}

func showIntroduction() {
	var nome string = "Caique"
	idade := 24

	fmt.Println("Hello sr.", nome, "your age is", idade)
	//fmt.Println("Variable idade type:", reflect.TypeOf(idade))
}

func showMenu() {
	fmt.Println("\n1- Start monitoring")
	fmt.Println("2- Show logs")
	fmt.Println("0- Exit")
}

func readCommand() int {
	var readedCommand int

	//fmt.Scanf("%d", &readedCommand)
	fmt.Scan(&readedCommand)

	fmt.Println("Selected:", readedCommand)
	return readedCommand
}

func startMonitoring() {
	fmt.Println("Monitoring...")

	sites := readSitesFromFile()

	if len(sites) == 0 {
		return
	}

	for i := 0; i < monitoringLoopTimes; i++ {

		for i, site := range sites {
			testSite(i, site)
		}

		time.Sleep(monitoringTimeDelay * monitoringTimeType)

	}

}

func readSitesFromFile() []string {

	var sites []string

	//file, err := ioutil.ReadFile("sites.txt")
	file, err := os.Open("sites.txt")

	if err != nil {
		fmt.Println("Error:", err)
		return sites
	}

	reader := bufio.NewReader(file)

	for {
		// using ' to say that \n is a byte and not a string
		line, err := reader.ReadString('\n')

		//fmt.Println(line)

		if err == io.EOF {

			if len(strings.TrimSpace(line)) != 0 {
				sites = addLineToSlice(line, sites)
			}

			break
		}

		sites = addLineToSlice(line, sites)
	}

	file.Close()

	return sites

}

func addLineToSlice(line string, slice []string) []string {
	return append(slice, strings.TrimSpace(line))
}

func testSite(siteIndex int, site string) {
	resp, err := http.Get(site)

	if err != nil {
		fmt.Println("Site request error:", err)
		return
	}

	isStatusSuccessfull := resp.StatusCode == 200

	if isStatusSuccessfull {
		fmt.Println("Site", siteIndex, "-", site, "loaded successfully")
	} else {
		fmt.Println("Site", siteIndex, "-", site, "has failed to load. Status code:", resp.Status)
	}

	registerMonitoringLog(site, isStatusSuccessfull)
}

func registerMonitoringLog(site string, status bool) {
	file, err := os.OpenFile(logFileName, os.O_CREATE|os.O_APPEND|os.O_WRONLY, 0777)

	if err != nil {
		fmt.Println("Error opening log file:", err)
		return
	}

	file.WriteString(time.Now().Format("02/01/2006 15:04:05.000") + " - " + site + "- online:" + strconv.FormatBool(status) + "\n")

	file.Close()

}

func printLogs() {
	fileBytes, err := ioutil.ReadFile(logFileName)

	if err != nil {
		fmt.Println(err)
	}

	fmt.Println(string(fileBytes))

}
