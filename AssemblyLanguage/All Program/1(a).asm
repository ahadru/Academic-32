.DATA  
    INPUT_PROMT DB "Enter a string: $"  
    OUTPUT_PROMT DB "Output string: $"  
    MSG DB 100 DUP(?)
    NEW_LINE DB 0AH, 0DH,"$"

.CODE
MAIN PROC

    MOV AX,@DATA
    MOV DS,AX      
     
    MOV AH,09H
    LEA DX, INPUT_PROMT
    INT 21H
    
    
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
    LEA DX, OUTPUT_PROMT
    INT 21H
           
    LEA DX, MSG
    INT 21H
    
    MOV AH,4CH
    INT 21H
MAIN ENDP
END MAIN
    