var input = "Greetings by Andrea & Giovanni!"

var encoded = URLEncoder.encode(input, StandardCharsets.UTF_16)
// Greetings+by+Andrea+%FE%FF%00%26+Giovanni%FE%FF%00%21

var decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_16)

System.out.println(input.equals(decoded)) // true