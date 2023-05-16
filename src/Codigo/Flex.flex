package Codigo;
import static Lex.Token.*;
import Lex.Token;

%%
%class Flex
%type Token

palabras=[a-zA-Z_]+
digito=[0-9]+
espacio=[ ,\n,\r,\t]+
operador_logicos=[&, !, |]
operador_rela=[>,<,==,!=,<=,>=]
operador_aritmetico=[+,-,*,/]


%{
    public String analisis;
%}

%%
if | else | elseif | for | int | boolean | try | catch | float | true | false | 
public | static | private | void | main | import | string | random | println | 
math | close | finally | from | class | double | char | byte | mov | dword | 
bit {analisis=yytext (); return Palabras_reservadas;}

{espacio} {/*ignorar*/}
{operador_logicos} {return Logicos;}
{operador_aritmetico} {return Aritmetico;}
{operador_rela} {return Relacional;}
{palabras}({palabras}|{digito})* {analisis=yytext(); return Palabra;}
("-"?)({digito}+("."{digito}+)?|("."{digito}+)) {analisis=yytext(); return Numero;}
. {return Error;}