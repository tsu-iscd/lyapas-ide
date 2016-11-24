grammar lyapas;

programm
	:function+
	;
		/*функция*/
		
		
	/***********Заголовок*************/
function
	:header body end
	; 
header
	:ENTER? name arguments end
	;
name
	:(LETTER (LETTER | LOW_LINE) (LETTER | constant | LOW_LINE)* L_PAR) | ((NOFLK)(LETTER | constant | LOW_LINE)* L_PAR)
	;
arguments
	: prog_args SLASH prog_args R_PAR
	;
prog_args
	:((VAR | constant)  (COMA (VAR | constant))*)?
	;
prog_arg
	:
	 arg 
	|comp 
	;
/*****************************************************************************************************/
		/*********Тело***************/
body
	:
	 expression+ paragraph+
	|expression+
	|paragraph+
	;
paragraph
	:
      PARAGRAPH constant expression*
    ;

expression:
      operation 
    | jump_cond 
    | comp_op
    | console_op 
;

operation:  
      value_transfer_op 
    | logic_arithm_op 
    | jump_op
    | call_op
;

jump_cond:
      UP_ARROW L_PAR arg JE arg R_PAR constant 
    | UP_ARROW L_PAR arg JNE arg R_PAR constant 
    | UP_ARROW L_PAR arg JLE arg R_PAR constant
    | UP_ARROW L_PAR arg JGE arg R_PAR constant
    | UP_ARROW L_PAR arg L_ANG_BRACK arg R_PAR constant
    | UP_ARROW L_PAR arg R_ANG_BRACK arg R_PAR constant
;


comp_op:
      AT_SIGN PLUS comp L_PAR arg R_PAR 
    | AT_SIGN MINUS comp
    | AT_SIGN PERCENT comp 
    | SET_MIN comp
    | AT_SIGN QUOTE SCONST QUOTE R_ANG_BRACK comp
    | AT_SIGN R_ANG_BRACK comp
    | AT_SIGN R_ANG_BRACK comp_el
    | AT_SIGN L_ANG_BRACK comp 
    | AT_SIGN L_ANG_BRACK comp_el
;

console_op:
      SLASH comp R_ANG_BRACK CONSOLE
    | SLASH comp L_ANG_BRACK CONSOLE
    | SLASH QUOTE SCONST QUOTE R_ANG_BRACK CONSOLE
    | SLASH comp R_ANG_BRACK CONSOLE constant L_BRACK QUOTE SCONST QUOTE R_BRACK
    | SLASH comp R_ANG_BRACK CONSOLE constant L_BRACK comp R_BRACK
    | SLASH comp L_ANG_BRACK CONSOLE constant L_BRACK QUOTE SCONST QUOTE R_BRACK
    | SLASH comp L_ANG_BRACK CONSOLE constant L_BRACK comp R_BRACK
;

value_transfer_op:
      SET_MIN arg 
    | SET_MAX arg
    | ASSIGN arg 
    | arg
    | SWAP L_PAR VAR VAR R_PAR
    | SWAP L_PAR comp VAR constant R_PAR
    | SWAP L_PAR comp DOT constant VAR R_PAR
    | SWAP L_PAR comp DOT constant DOT  constant R_PAR
    | LETTER_X
    | ASSIGN LETTER_X
    | GET_TIME
;

logic_arithm_op:
      LEAST_BIT
    | NOT
    | PERCENT
    | OR arg
    | AND arg
    | XOR arg
    | L_ANG_BRACK arg
    | R_ANG_BRACK arg
    | PLUS arg
    | MINUS arg
    | STAR arg
    | DIV arg
    | SLASH arg
    | MOD arg
    | INC arg
    | DEC arg
;

jump_op:
      JMP constant
    | JZ constant
    | JNZ constant
    | UP_ARROW L_PAR arg R_PAR
    | UP_ARROW LETTER_X  constant arg arg
    | UP_ARROW R_ANG_BRACK
    | L_CURL ASM R_CURL
;

call_op:
    STAR VAR header
;

arg:
	 constant 
    | comp_el
    | VAR 
    | COMP_CAP constant
    | COMP_CARD constant
;

comp_el:
   	  G_COMP VAR 
    | G_COMP constant
    | G_COMP L_BRACK VAR R_BRACK
    | G_COMP L_BRACK constant R_BRACK
    | comp DOT constant
    | comp VAR 
;
/*************************************************************************************************/  
		/************конец**********/
end
	: ENTER FRET
	;


/*************************************************************************************************/

constant
	:
	 dconst
	|hconst
	|oconst
	|bconst
	;
dconst
	:(DDIGIT)+
	;
hconst
	:(HDIGIT)+ H
	;
oconst
	:(ODIGIT)+ O
	;
bconst
	:(BDIGIT)+ B
	;
comp
	:
      L_COMP constant
    | S_COMP constant
    ;
S_COMP
	:'F' ('0'..'9')+
	;
L_COMP
	:'L' ('0'..'9')+
	;

H
	:'h'
	;
O
	:'o'
	;
B
	:'b'
	;
	
ENTER
	:'\n'
	;

LOW_LINE
	: '_'
	;

VAR
	:('a'..'z')
	;

LETTER
	: ('a' .. 'z') | ('A' .. 'Z')
	;


DDIGIT
	: ('0' .. '9')
	;
	
HDIGIT
	:('0'..'9') | ('A'..'F')
	;
	
ODIGIT
	:('0'..'7')
	;
	
BDIGIT
	: '1' 
	| '2'
	;
	
NOFLK
	:('a'..'z') | ('A'..'E') | ('G'..'I') | ('M'..'Z')
	;

ASM
	:('\u0001'..'\uFFFF')+
	;

SCONST
	: ('\u0001'..'\uFFFF')+
	;

/**********************************************************************************************/

		
SUMBOL
	:'F'
	;
	
LOGIC
	:'L'
	;
	
GLOBAL
	:'K'
	;
	
CAPACITY
	:'S'
	;
	
CARDINALITY
	:'Q'
	;
	
SET_BIT
	:'I'
	;
	
SPEC_VAR
	:'Z'
	;
	
FRET
	:'**'
	;
	
/**********************************************************************************************/


		/* Логические и арифметические операции*/
INC
	:'∆'
	;
	
DEC
	:'∇'
	;
	
MOD
	:';'
	;
	
DIV
	:':'
	;
	
OR
	:'∨'
	;
	
AND
	:'&'
	;
	
XOR
	:'⊕'
	;
	
NOT
	:'¬'
	;
	
LEAST_BIT
	:'!'
	;
	
CONSOLE
	:'C'
	;
	
L_ANG_BRACK
	:'<'
	;
	
R_ANG_BRACK
	:'>'
	;
	
SLASH
	:'/'
	;
	
LETTER_X
	:'X'
	;
	
STAR
	:'*'
	;
	
UP_ARROW
	:'↑'
	;
	
COPY
	:'#'
	;
	
AT_SIGN
	:'@'
	;
	
PLUS
	:'+'
	;
	
MINUS
	:'-'
	;
	
PERCENT
	:'%'
	;
	
SET_MIN
	:'O'
	;
	
SET_MAX
	:'⁻'
	;
	
ASSIGN
	:'⇒'
	;
	
SWAP
	:'⇔'
	;
	
GET_TIME
	:'T'
	;
/************************************************************************************************/



PARAGRAPH
	:'§'
	;
	
JE
	:'='
	;
	
JNE
	:'≠'
	;
	
JGE
	:'≥'
	;
	
JLE
	:'≤'
	;
JMP
	:'→'
	;
	
JZ
	:'↪'
	;
	
JNZ
	:'↪'
	;
	
L_PAR
	:'('
	;
	
R_PAR
	:')'
	;
	
L_BRACK
	:'['
	;
	
R_BRACK
	:']'
	;
	
L_CURL
	:'{'
	;
	
R_CURL
	:'}'
	;
	
QUOTE
	:'\''
	;
	
COMA
	:','
	;
	
DOT
	:'.'
	;
/******************************************************************************/

	
G_COMP
	:'K' ('0'..'9')+
	;
	
COMP_CAP
	:'Q' ('0'..'9')+
	;
	
COMP_CARD
	:'S' ('0'..'9')+
	;

