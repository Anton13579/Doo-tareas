package database;
import java.io.*;
import java.text.ParseException;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.*;
import week7.models.User;

public class Database {
       
//-------------------------------------------------------------------------------------------------------------------
    private static String getPathDatabase() {
        return "C:\\Users\\Familia\\Documents\\NetBeansProjects\\Laboratorio6\\src\\java\\database\\newjson.json";
    }
//-------------------------------------------------------------------------------------------------------------------
    private static boolean setJsonObject(String name, String lastName, String username, String password){
        JSONObject  obj = new JSONObject();

       //Solo guarda un valor
       obj.put("Nombre",name);
       obj.put("Apellidos",lastName);
       obj.put("Usuario",username);
       obj.put("Contraseña",password);

       String rutaJson = getPathDatabase(); //llamada a método anterior getPathDatabase

       try (FileWriter file = new FileWriter(rutaJson)) {
               file.write(obj.toJSONString());

               return true;
       }
       catch(IOException ioext) {
           return false;
       }
    }
//-------------------------------------------------------------------------------------------------------------------    
   /*
    getJsonObject():JSONObject: Devuelve un objeto 
    de tipo JSONObject con la información almacenada 
    en el archivo JSON. 
    Ejemplo:
   */
    private static JSONObject getJsonObject() {

        try {
            String rutaJson = getPathDatabase();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(rutaJson));

            /*
            JsonObject jsonObject = new JsonParser().parse("{\"name\": \"John\"}").getAsJsonObject();

System.out.println(jsonObject.get("name").getAsString()); //John
            */
            
            JSONObject jsonObject =  (JSONObject) obj;

            return jsonObject;
        }
        catch(IOException | ParseException ioext) {
            return null;
        }
    }
//-------------------------------------------------------------------------------------------------------------------    
    /*
    getUserByUsername(username:String):User: Devuelve 
    un objeto de tipo User con la información del archivo JSON.
    */
    public static User getUserByUsername(String username) {
        User user;

        JSONObject jsonObject = getJsonObject(); //llama a método anterior

        if(jsonObject != null) {
            String nameDb = (String) jsonObject.get("Nombre");
            String lastNameDb = (String) jsonObject.get("Apellidos");
            String usernameDb = (String) jsonObject.get("Usuario");
            String passwordDb = (String) jsonObject.get("Contraseña");
            
            //Valida si el usuario que se pide es igual al que se encuentra
            //en el archivo JSON
            if(username.equals(usernameDb)) {
                user = new User(nameDb, lastNameDb, usernameDb, passwordDb); //Completar con todas las propiedades del usuario
            }
            else {
                user = null;
            }

            return user;
        }
        else{
            return null;
        }
    }
//-------------------------------------------------------------------------------------------------------------------    
    /*
    getUserByUsernamePassword(username:String, password:String):User: Devuelve un objeto 
    de tipo User con la información del archivo JSON. Ejemplo:
    */
    
    public static User getUserByUsernamePassword(String username, String password){
        User user;

        JSONObject jsonObject = getJsonObject(); //Llamáda a método

        if(jsonObject != null) {
            String nameDb = (String) jsonObject.get("Nombre");
            String lastNameDb = (String) jsonObject.get("Apellidos");
            String usernameDb = (String) jsonObject.get("Usuario");
            String passwordDb = (String) jsonObject.get("Contraseña");

            //Validar password y usuario
            //passwordDb no existe en este contexto. Usar el ejemplo de propiedadDb
            if(username.equals(usernameDb) && password.equals(passwordDb)) {
                user = new User(nameDb, lastNameDb, usernameDb, passwordDb); //Completar con todas las propiedades del usuario
            }
            else {
                user = null;
            }

            return user;
        }
        else{
            return null;
        }
    }
    /*
        setUser(name:String, 
    lastName:String, 
    username:String, 
    password:String):boolean: Devuelve true|false en caso de 
    crearse o no, el usuario. 
    Ejemplo:
    */
    public static boolean setUser(String name, String lastName, String username, String password) {

        boolean isSetup = setJsonObject(name, lastName, username, password);

        return isSetup;
    }
    
}
