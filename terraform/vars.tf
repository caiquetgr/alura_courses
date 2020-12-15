variable "amis" {
  type = map(string)
  default = {
    "sa-east-1" = "ami-0c3c87b7d583d618f"
    "us-east-1" = "ami-04d29b6f966df1537"
  }
}

variable "cdirs_acesso_remoto" {
  type    = list(string)
  default = ["179.209.45.66/32"]
}

variable "key_name" {
  type    = string
  default = "terraform"
}
