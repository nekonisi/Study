#include <stdio.h>
#include <stdlib.h>

int main()
{

	int _int;

	do{
		printf("整数値を入力してください。(0で終了)\n");
		scanf_s("%d", &_int);
		printf("入力された数: %d\n",_int);
	} while (_int);

	system("pause");
	return 0;
}