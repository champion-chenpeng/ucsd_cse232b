grammar XPath;

@header {
    package com.cse232b.antlr4;
}
//absolute path
ap  : doc '/' rp    #singleAP
    | doc '//' rp   #doubleAP
    ;

// document
doc : ('doc("' | 'document("') fileName '")'
    ;

// relative path
rp  : tagName       #tagRP
    | '*'           #childrenRP
    | '.'           #selfRP
    | '..'          #parentRP
    | 'text()'      #textRP
    | '@' attrName  #attrRP
    | '(' rp ')'    #bracketRP
    | rp '/' rp     #singleSlashRP
    | rp '//' rp    #doubleSlashRP
    | rp '[' f ']'  #filterRP
    | rp ',' rp     #commaRP
    ;

//filter
f   : rp        #rpFilter
    | rp EQ rp  #eqFilter
    | rp IS rp  #isFilter
	| rp '=' stringCondition #stringFilter
    | '(' f ')' #bracketFilter
    | f 'and' f #andFilter
    | f 'or' f  #orFilter
    | 'not' f   #notFilter
    ;

tagName : ID;
attrName : ID;
stringCondition : StringConstant;

EQ: '=' | 'eq';
IS  : '==' | 'is';
ID  : [a-zA-Z0-9_-]+ ;
StringConstant: '"'+[a-zA-Z0-9,.!?; '"-]+'"';

fileName    : FILENAME;
FILENAME    : [a-zA-Z0-9._-]+;

WHITESPACE  : [ \t\r\n]+ -> skip;
