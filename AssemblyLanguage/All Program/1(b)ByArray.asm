INCLUDE 'EMU8086.INC'

.MODEL SMALL
.STACK 100H

.DATA
    str DB 80 DUP(?)  
    i DB ?
    j DB ?
    
        
.CODE
MAIN PROC 
    MOV AX, @DATA
    MOV DS, AX
    PRINT 'Enter the string : '
    
    LEA SI, str   
    MOV CL, 0
    INPUT:
        MOV AH,1
        INT 21H
        
        CMP AL, 13
        JZ ENDINPUT
        
        MOV str[SI], AL
        INC SI
        INC CL
        
        JMP INPUT
        
    ENDINPUT:
        MOV str[SI], "$"
    
    CALL DSORT
    
    CALL NEWLINE
    
    PRINT 'Sorted string : '
    
    LEA DX, STR
    MOV AH, 9
    INT 21H
    
    
    MOV AH,4CH
    INT 21H
MAIN ENDP

NEWLINE PROC
    MOV AH,2
    MOV DL,10
    INT 21H
    
    MOV DL,13
    INT 21H
    RET
NEWLINE ENDP

ASORT PROC
    MOV i, 0
    MOV j, 0
    LEA SI, str 
   
    AFOR1:
        MOV BL, i
        CMP BL, CL
        JE ENDAFOR1
             
        MOV BL, i;
        MOV j, BL
        INC j  
        MOV DI, SI
        INC DI           
        AFOR2:              
            MOV BL, j             
            
            CMP BL, CL
            JE ENDAFOR2
            
            MOV AL, str[SI]
            CMP AL, str[DI]
            JG ASWAP
            INC j 
            INC DI
            JMP AFOR2
                    
            ASWAP:
                MOV AL, STR[SI]
                XCHG AL, STR[DI]
                MOV STR[SI], AL           
                
                INC j
                INC DI
                JMP AFOR2
            
        ENDAFOR2:                                
        INC SI
        INC i
        JMP AFOR1
    ENDAFOR1:            
    
    RET
ASORT ENDP

DSORT PROC
    MOV i, 0
    MOV j, 0
    LEA SI, str 
   
    DFOR1:
        MOV BL, i
        CMP BL, CL
        JE ENDDFOR1
             
        MOV BL, i;
        MOV j, BL
        INC j  
        MOV DI, SI
        INC DI           
        DFOR2:              
            MOV BL, j             
            
            CMP BL, CL
            JE ENDDFOR2
            
            MOV AL, str[SI]
            CMP AL, str[DI]
            JL DSWAP
            INC j 
            INC DI
            JMP DFOR2
                    
            DSWAP:
                MOV AL, STR[SI]
                XCHG AL, STR[DI]
                MOV STR[SI], AL           
                
                INC j
                INC DI
                JMP DFOR2
            
        ENDDFOR2:                                
        INC SI
        INC i
        JMP DFOR1
    ENDDFOR1:
    RET
DSORT ENDP
    
END MAIN