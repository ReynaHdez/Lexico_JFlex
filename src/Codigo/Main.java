package Codigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import Lex.*;


public class Main {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("C:/VsCode/Java/Analizador_Lexico/Lexico_JFlex/src/Archivos/entrada"));
            BufferedWriter out = new BufferedWriter(new FileWriter("C:/VsCode/Java/Analizador_Lexico/Lexico_JFlex/src/Archivos/salida"))) {

            Flex lexer = new Flex(in);
            Token token;

            while ((token = lexer.yylex()) != null) {
                out.write(token.toString());
                if (lexer.yylength() > 0) {
                    out.write(", ");
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
