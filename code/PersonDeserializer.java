class PersonDeserializer { private Gson gson = new Gson();
  public Person deserialize(String string) {
    JsonElement ast = gson.fromJson(string, JsonElement.class);
    return fromJsonElement(ast);
  }
  private Person fromJsonElement(JsonElement element) {
    if (element instanceof JsonObject) {
      var obj = (JsonObject) jsonElement;
      if (obj.has("name") && obj.has("email") && obj.has("age")) {
        var name = obj.getAsJsonPrimitive("name");
        var email = obj.getAsJsonPrimitive("email");
        var age = obj.getAsJsonPrimitive("age");
        return new Person(name, email, age);
      }
    }
    throw new IllegalStateException("Cannot parse: " + element);
  }
}
