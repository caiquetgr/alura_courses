resource "aws_security_group" "acesso_ssh" {
  name        = "acesso_ssh"
  description = "Permite acesso SSH para maquinas"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = var.cdirs_acesso_remoto
  }

  tags = {
    Name = "ssh"
  }
}

resource "aws_security_group" "acesso_ssh-us-east-1" {
  provider    = aws.regiao-us-east-1
  name        = "acesso_ssh"
  description = "Permite acesso SSH para maquinas"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = var.cdirs_acesso_remoto
  }

  tags = {
    Name = "ssh"
  }
}
