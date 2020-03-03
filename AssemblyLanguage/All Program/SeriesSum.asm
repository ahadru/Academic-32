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
    MOV AL,0  
    L1:      
       ADD AL,CL
       DEC CL   
       JNZ L1
    
    ADD AL,'0'
    MOV RESULT,AL
       
    CALL NEWLINE
    
    PRINT "SUM OF SERIES : " 
    
    MOV DL,RESULT
    MOV AH,2
    INT 21H
    
    
    MOV AX,4CH
    INT 21H
MAIN ENDP    

NEWLINE PROC
    MOV AH, 2
    MOV DL, 10
    INT 21H
    MOV DL, 13
    INT 21H
    RET
NEWLINE ENDP    
END MAIN