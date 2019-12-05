.MODEL SMALL
.DATA
        STR1    DB      80   DUP(?),'$'
        STR2    DB      80   DUP(?),'$'
        NL      DB      0DH,0AH,'$'   
        MSG DB "Enter a String: $"  
        
.CODE
MAIN    PROC
        MOV AX,@DATA
        MOV DS,AX     
        
        MOV AH,9
        LEA DX,MSG
        INT 21H

        LEA SI,STR1
        LEA DI,STR2

        MOV AH,01H
                
INPUT:
        INT 21H
        CMP AL,0DH
        JE  ENDPROGRAM  
        MOV [SI],AL
        INC SI
        JMP INPUT
        
ENDPROGRAM:
        MOV AL,'$'
        MOV [SI],AL

        MOV AH,09H
        LEA DX,NL
        INT 21H

        MOV CX, SI 

REVERSE:
        DEC SI
        MOV AL,[SI]

        MOV [DI],AL
        INC DI
        LOOP REVERSE

        MOV AL,'$'
        MOV [DI],AL

        MOV AH,09H

        LEA DX,NL
        INT 21H

        LEA DX,STR2
        INT 21H

        MOV AH,4CH
        INT 21H

MAIN    ENDP
END   MAIN

