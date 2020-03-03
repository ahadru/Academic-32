INCLUDE 'EMU8086.INC'

.MODEL SMALL
.STACK 100H
.DATA
    RESULT DB ?
    
.CODE
MAIN PROC
    MOV AX,@DATA
    MOV DS,AX

    PRINT "TAKE INPUT FORM 1 TO 3 : "
    MOV AH,01H
    INT 21H 
    
    SUB AL,'0' 
    MOV CL,AL  
    MOV AL,1  
    L1:      
       MUL CL
       DEC CL   
       JNZ L1
    
    ADD AL,'0'
    MOV RESULT,AL
       
    CALL NEWLINE
    
    PRINT "FACTORIAL : " 
    
    MOV DL,RESULT
    MOV AH,2
    INT 21H
    
    
    MOV AX,4CH
    INT 21H
MAIN ENDP    

FACTORIAL PROC
    MOV AX, 1
    TOP:
    MUL CX
    LOOP TOP
    RET
FACTORIAL ENDP   

INTEGER_PRINT PROC                      
    MOV BL, 10   
    MOV CX, 0 
TOP:    
    DIV BL
    PUSH AH
    INC CX  
    CMP AL, 0
    JE END
    JMP TOP
ENDTOP:       
    MOV AH, 2
    POP DL
    INT 21H   
    LOOP ENDTOP
                         
    RET                    
INTEGER_PRINT ENDP


NEWLINE PROC
    MOV AH, 2
    MOV DL, 10
    INT 21H
    MOV DL, 13
    INT 21H
    RET
NEWLINE ENDP    
END MAIN