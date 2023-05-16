package Codigo;

public class App {
    public static void main(String[] args) throws Exception{
        String direccion = "C:/VsCode/Java/Analizador_Lexico/Lexico_JFlex/src/Codigo/Flex.flex";
        generar_lexema(direccion);
    }

    public static void generar_lexema(String ruta) {
        try {
            String[] archivo = {ruta};
            jflex.Main.generate(archivo);
        } catch (Exception e) {
            System.out.println("No se ha generado el archivo flex " + e.getMessage());
        }
    }
}
