INCLUDE "EMU8086.INC"
.MODEL SMALL
.STACK 100H
.DATA 
    STR DB 80 DUP(?)
.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX
    
    PRINT "Enter a string: "
    LEA SI, STR   
    MOV CX, 0
    
INPUT:
    MOV AH, 01H
    INT 21H
    CMP AL, 13D
    JE ENDINPUT 
    
    MOV STR[SI], AL
    INC SI
    INC CX
    JMP INPUT    
               
ENDINPUT:
    CALL NEWLINE
    PRINT "Reversed string: "
    DEC SI

OUTPUT:
    MOV AH, 02H
    MOV DL, STR[SI]
    INT 21H
    
    DEC CX
    CMP CX, 0
    JE ENDOUTPUT
    DEC SI
    JMP OUTPUT             
               
               
ENDOUTPUT:
               
    MOV AH, 4CH
    INT 21H   
    
MAIN ENDP


NEWLINE PROC
    MOV AH, 2H
    MOV DL, 0AH
    INT 21H
    MOV DL, 0DH
    INT 21H
    RET
NEWLINE ENDP
END MAIN
