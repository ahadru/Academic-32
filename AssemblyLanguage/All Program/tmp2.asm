.DATA
    MSG DB "Hello$"    
    NEW_LINE DB 0AH,0DH,"$"

.CODE
MAIN PROC

    MOV AX,@DATA
    MOV DS,AX  
    
    MOV AH,09H
    LEA DX, NEW_LINE
    INT 21H         
    LEA DX, MSG
    INT 21H
    
    MOV AH,4CH
    INT 21H
MAIN ENDP
END MAIN