grammar lyapas;

function
	:header body end
	; 
header
	: name arguments
	;
name
	:NAME_FUNC
	;

arguments : ARGUMENTS ;
prog_args : PROG_ARGS ;

/*************************************************************************************************/  
		/************конец**********/
end
	:FRET
	;


/**************************************BODY***************************************************/

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

arg: ARG ;

comp_el: COMP_EL ;

ARG: CONSTANT | COMP_EL | VAR | COMP_CAP CONSTANT | COMP_CARD CONSTANT ;

COMP_EL:  G_COMP VAR | G_COMP CONSTANT | G_COMP L_BRACK VAR R_BRACK | G_COMP L_BRACK CONSTANT R_BRACK | COMP DOT CONSTANT | COMP VAR; 

/*************************************************************************************************/

constant : CONSTANT ;
dconst : DCONST ;
hconst : HCONST ;
oconst : OCONST ;
bconst : BCONST ;
comp : COMP ;

ARGUMENTS : PROG_ARGS SLASH PROG_ARGS R_PAR ;

PROG_ARGS : ((VAR | CONSTANT) (COMA (VAR | CONSTANT))*)? ;

NAME_FUNC: (LETTER (LETTER | LOW_LINE) (LETTER | CONSTANT | LOW_LINE)* L_PAR) | ((NOFLK)(LETTER | CONSTANT | LOW_LINE)* L_PAR) ;



CONSTANT: DCONST | HCONST | OCONST | BCONST ;

DCONST : (DDIGIT)+ ;

HCONST : (HDIGIT)+ H ;

OCONST : (ODIGIT)+ O ;

BCONST : (BDIGIT)+ B ;

COMP : L_COMP CONSTANT | S_COMP CONSTANT ;

fragment G_COMP
	:'K' DDIGIT+ ;
	
fragment COMP_CAP
	:'G' DDIGIT+ ;
	
fragment COMP_CARD
	:'S' DDIGIT+ ;

fragment S_COMP
			:'F' DDIGIT+ ;

fragment L_COMP
			:'L' DDIGIT+ ;

fragment HDIGIT
			: DDIGIT | ('A'..'F') ;
	
fragment DDIGIT
			: ODIGIT | '8' | '9' ;
	
fragment ODIGIT
			: ('0'..'7') ;
		
fragment BDIGIT
			: '1' | '2' ;


fragment H: 'h' ;

fragment O :'o' ;

fragment B :'b' ;

fragment LETTER
	: ('a'..'z') | ('A' .. 'Z')
	;

fragment NOFLK
	: ('a'..'z') | ('A'..'E') | ('G'..'I') | ('M'..'Z') ;


VAR : ('a'..'z') ;

fragment LOW_LINE
	: '_'
	;

/************************NORM**********************************************************/


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


/*************************NORM*********************************************************/

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
	
fragment COMA
	:','
	;
	
DOT
	:'.'
	;

/**************************************/

ASM
	:('\u0001'..'\uFFFF')+
	;

SCONST
	: ('\u0001'..'\uFFFF')+
	;


FRET
	:'**'
	;

COMMENT
    : ('\n' | '\r' | '\t') -> skip
    ;
