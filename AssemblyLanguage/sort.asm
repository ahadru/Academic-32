.Model small
.Stack
.Data

		msg1 db " Enter the String :   $"
		msg2 db 0dh,0ah,"     :After converted$"

		var dw ?
	    var2 dw ?

	strr db 200 dup(?)

	   

.Code

Task3: 	
		mov ax,@data
		mov ds,ax

	  mov dx,offset msg1
	mov ah,09h
	int 21h

	   mov bx ,0

	mov si,0
lop:

	mov ah ,01h
	int 21h

	mov strr[si],al
	
 	
		inc bx

		cmp strr[si],0dh
		je end_input
	inc si
jmp lop
end_input:
mov var2,bx

dec bx
mov cx,bx


output:
 
	
	 mov si,0
loop1:
		  inc si
	cmp si,cx
		
	JA loop2
	
	mov bx,si
	mov di,bx
	dec di
	mov dl,strr[di]

	cmp dl,strr[si]
	   
	jBE loop1
	
		mov al, dl
		mov bl,strr[si]
	mov strr[di],bl
	mov strr[si],al
		
	jmp loop1

loop2:

loop output

mov ah,09h
mov dx,offset msg2
int 21h

mov ah,02h
mov cx,var2
mov si,0

print:

		mov dl,strr[si]
		int 21h

		inc si

loop print
	

end_:


	mov ah,4ch
	int 21h

end Task3

