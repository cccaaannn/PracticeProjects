INCLUDE Irvine32.inc

.386
.model flat, stdcall
.stack 4096
ExitProcess PROTO, dwExitCode:DWORD

.data
operation DWORD ?
num1 DWORD ?
num2 DWORD ?
result DWORD ?

wellcomeMessage BYTE "---------- ---------- Welcome to calculator ---------- ----------", 10, 10, 0
menuMessage BYTE "---------- Please choose operation ----------", 10, "0-exit", 10, "1-sum", 10, "2-subtract", 10, "3-multiply", 10, "4-divide", 10, ": ", 0
num1Message BYTE "Enter num 1: ", 0
num2Message BYTE "Enter num 2: ", 0
resultMessage BYTE "Result is: ", 0
endline BYTE 10, 0
lineSeperator BYTE "---------- ---------- ---------- ---------- ----------", 10, 0

.code
main PROC
	call menu
	INVOKE ExitProcess, 0
main ENDP

menu PROC
	; shows wellcome message
	mov edx, OFFSET wellcomeMessage
	call WriteString

	menuLoop:
		; shows menu message
		mov edx, OFFSET menuMessage			; move menuMessage to edx
		call WriteString					; show the message, WriteString uses edx register
		call ReadInt						; ReadChar reads to al
		mov operation, eax					; move the value from al to operation for later usage

		; seperates lines
		mov edx, OFFSET endline
		call WriteString
		
		; menu selection
		cmp operation, 0
		je ifExit

		cmp operation, 1
		je ifSum

		cmp operation, 2
		je ifSubtract

		cmp operation, 3
		je ifMultiply

		cmp operation, 4
		je ifDivide
	jmp menuLoop


	ifSum:
		call getNumbers
		call sum
		call showResult
		jmp menuLoop
	ifSubtract:
		call getNumbers
		call subtract
		call showResult
		jmp menuLoop
	ifMultiply:
		call getNumbers
		call multiply
		call showResult
		jmp menuLoop
	ifDivide:
		call getNumbers
		call divide
		call showResult
		jmp menuLoop
	ifExit:
		ret

menu ENDP



getNumbers PROC
	; gets numbers from user
	mov edx, OFFSET num1Message				; move num1Message to edx
	call WriteString						; show the message, WriteString uses edx register
	call ReadInt							; ReadInt reads int to eax
	mov num1, eax							; move the value from eax to num1

	mov edx, OFFSET num2Message
	call WriteString
	call ReadInt
	mov num2, eax

	ret
getNumbers ENDP

showResult PROC
	; shows the result
	mov edx, OFFSET resultMessage			; move resultMessage to edx
	call WriteString						; show the message, WriteString uses edx register
	mov eax, result							; move result to eax
	call WriteInt							; show the value, WriteInt uses eax register

	; seperates line
	mov edx, OFFSET endline
	call WriteString
	mov edx, OFFSET lineSeperator
	call WriteString
	mov edx, OFFSET endline
	call WriteString

	ret
showResult ENDP

sum PROC
	mov eax, num1
	add eax, num2
	mov result, eax
	ret
sum ENDP

subtract PROC
	mov eax, num1
	sub eax, num2
	mov result, eax
	ret
subtract ENDP

multiply PROC
	mov eax, num1
	imul num2
	mov result, eax
	ret
multiply ENDP

divide PROC
	; edx eax
	; -------
	;  num2

	mov edx, 0								; clear dividend
	mov eax, num1
	div num2
	mov result, eax
	ret
divide ENDP

END main