grammar CalExpr;

prog:   stat+ ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   CLEANMEM                    # cleanmem
    |   NEWLINE                     # blank
    ;

expr:   expr '!'                    # fac
    |   expr '^' expr               # pow
    |   expr op=('*'|'/') expr      # MulDiv
    |   expr op=('+'|'-') expr      # AddSub
    |   NUMBER                      # number
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

CLEANMEM: 'CLEANMEM';
FAC :   '!' ;
POW :   '^' ;
MUL :   '*' ;
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
DOT :   '.' ;
ID  :   [a-zA-Z]+ ;
NUMBER :   [0-9]+ (DOT)? [0-9]*;
NEWLINE:'\r'? '\n' ;
WS  :   [ \t]+ -> skip ;