.MODEL SMALL
.STACK 200H
.DATA
     NUM DB 48
     CHAR DB 'A'
     MSG DB "HELLO AHAD$"
.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX
    
    ;PRINT CHAR VARIABLE
    MOV DL, CHAR
    MOV AH, 2H
    INT 21H 
    
    ;PRINT NEW LINE
    MOV AH, 2
    MOV DL, 0AH
    INT 21H
    MOV DL, 0DH
    INT 21H    
    
    ;PRINT NUM VARIABLE
    MOV DL, NUM
    MOV AH, 2H
    INT 21H   
    
    ;PRINT NEW LINE
    MOV AH, 2
    MOV DL, 0AH
    INT 21H
    MOV DL, 0DH
    INT 21H 
    
    ;PRINT MSG STRING 
    MOV AH, 09H
    MOV DX, OFFSET MSG ; READING OFFSET IT CAN BE LEA DX, MSG
    INT 21H
    
    MOV AH, 4CH
    INT 21H
MAIN ENDP
END MAIN
    