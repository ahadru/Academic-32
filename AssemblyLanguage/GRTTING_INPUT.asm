.MODEL SMALL
.STACK 200H
.DATA
     NUM DB ?
     CHAR DB 'A'
     MSG DB "HELLO AHAD$"
.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX
    
    MOV AH, 1
    INT 21H
    
    MOV AH, 2
    MOV DL, 0AH
    INT 21H
    MOV DL, 0DH
    INT 21H
    
    MOV DL, AL
    MOV AH, 2
    INT 21H 
    
    MOV AH, 4CH
    INT 21H
MAIN ENDP
END MAIN
    