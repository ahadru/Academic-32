INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA
    STR         DB 80 DUP(?)
    VOWELS      DB ?
    CONS        DB ?
    DIGITS      DB ?
    SPACES      DB ?  
    VOWEL_CHAR  DB "AEIOUaeiou$" 
MAIN PROC 
    MOV AX, @DATA
    MOV DS,AX         
    
    PRINT "Enter a String: "
    LEA SI, STR
    MOV CX, 0
    INPUT:
        MOV AH, 1
        INT 21H
        CMP AL, 13
        JE ENDINPUT
        
        MOV STR[SI], AL
        INC SI  
        
        ;checking vowel,consonants,digits,spaces
        CMP AL, 41H
        JGE ALPHABET
        CMP AL, 30H
        JGE DIGIT_S
        CMP AL, 20H
        JE SPACE_S
        JMP INPUT
        
        
        ALPHABET:
            PUSH AX 
            CALL IS_VOWEL   
            CMP AX, 1
            JNE C_S
            JMP INPUT
            C_S:
                INC CONS
              
            JMP INPUT
        DIGIT_S: 
            CMP AL, 39H
            JLE D_C
            JMP INPUT
            D_C:
                INC DIGITS           
            JMP INPUT
        SPACE_S:
            INC SPACES
            JMP INPUT
    ENDINPUT:    
        MOV STR[SI], "$"
        
    
    MOV AH,4CH
    INT 21H
MAIN ENDP  

IS_VOWEL PROC     
    MOV AX, @DATA
    MOV ES, AX 
    POP AX  
    MOV CX, 0AH
    CLD 
    LEA DI, VOWEL_CHAR
    REPNE SCASB
    JNZ END
    INC VOWELS   
    MOV AX, 1       
    END:
    MOV AX, 0       
    RET
IS_VOWEL ENDP
    

NEWLINE PROC
    MOV AH,2
    MOV DL,10
    INT 21H
    MOV DL,13
    INT 21H
    RET
NEWLINE ENDP
    
END MAIN 