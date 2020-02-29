
INCLUDE 'EMU8086.INC'

.MODEL SMALL
.STACK 100H

.DATA
    str DB "AHAD$"  
    I DB 0
        
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        MOV DL, str[I]
        MOV AH, 2
        INT 21H
       
        
        MOV AH,4CH
        INT 21H
    MAIN ENDP
    
END MAIN