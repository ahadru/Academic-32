.DATA
    MSG DB 100 DUP(?)
    NEW_LINE DB 10H,13H,"$"

.CODE
MAIN PROC

    MOV AX,@DATA
    MOV DS,AX  
    
    LEA SI, MSG
READ:MOV AH, 1
    INT 21H
    CMP AL, 0DH 
    JE WRITE
    MOV [SI], AL
    INC SI
    JMP READ    

WRITE:
    MOV AH,09H
    LEA DX, NEW_LINE
    INT 21H         
    LEA DX, MSG
    INT 21H
    
    MOV AH,4CH
    INT 21H
MAIN ENDP
END MAIN