.MODEL 
.DATA
.CODE
MAIN PROC
    MOV SI,8000
    MOV CX,[SI]
    MOV AX,0000
    MOV BX,ax
LABEL1: INC BX
    ADD AX,BX
    CMP BX,CX
    JNZ LABEL1
    MOV DI,8010
    MOV [DI],AX
    INT 03   


