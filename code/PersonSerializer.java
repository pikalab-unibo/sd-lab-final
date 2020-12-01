class PersonSerializer {
  private Gson gson = new Gson();

  public String serialize(Person person) {
    JsonElement ast = toJsonElement(person);
    return gson.toJson(ast);
  }

  private JsonElement toJsonElement(Person person) {
    var obj = new JsonObject();
    obj.addProperty("name", person.getName());
    obj.addProperty("email", person.getEmail());
    obj.addProperty("age", person.getAge());
    return obj;
  }
}