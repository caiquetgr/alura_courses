terraform {
  backend "remote" {
    hostname = "app.terraform.io"
    organization = "caiqueborges"

    workspaces {
      name = "curso-alura"
    }
  }
}