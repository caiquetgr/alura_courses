terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 2.70"
    }
  }
}

provider "aws" {
  region = "sa-east-1"
}

provider "aws" {
  alias  = "regiao-us-east-1"
  region = "us-east-1"
}

resource "aws_instance" "dev" {
  count         = 1
  ami           = var.amis["sa-east-1"]
  instance_type = "t2.micro"
  key_name      = var.key_name
  tags = {
    Name = "dev-${count.index}"
  }
  vpc_security_group_ids = [aws_security_group.acesso_ssh.id]
}

resource "aws_instance" "dev4" {
  ami           = var.amis["sa-east-1"]
  instance_type = "t2.micro"
  key_name      = var.key_name
  tags = {
    Name = "dev4"
  }
  vpc_security_group_ids = [aws_security_group.acesso_ssh.id]
  depends_on             = [aws_s3_bucket.dev4]
}

resource "aws_s3_bucket" "dev4" {
  bucket = "caiqueborges-dev4"
  acl    = "private"

  tags = {
    Name = "caiqueborges-dev4"
  }
}

resource "aws_instance" "dev5" {
  provider = aws.regiao-us-east-1
  ami           = var.amis["us-east-1"]
  instance_type = "t2.micro"
  key_name      = var.key_name
  tags = {
    Name = "dev5"
  }
  vpc_security_group_ids = [aws_security_group.acesso_ssh-us-east-1.id]
  depends_on = [ aws_dynamodb_table.dynamodb-homologacao ]
}