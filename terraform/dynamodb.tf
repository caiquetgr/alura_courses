resource "aws_dynamodb_table" "dynamodb-homologacao" {
  provider     = aws.regiao-us-east-1
  name         = "GameScores"
  billing_mode = "PAY_PER_REQUEST"
  //read_capacity  = 2
  //write_capacity = 2
  hash_key  = "UserId"
  range_key = "GameTitle"

  attribute {
    name = "UserId"
    type = "S"
  }

  attribute {
    name = "GameTitle"
    type = "S"
  }
}
