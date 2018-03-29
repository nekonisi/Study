import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Step4 {
	public static void main(String[] args) {

		// 最初のメッセージを表示するよ！
		ShowMessage(0);

		// キーボードからの読込
		Scanner scan = new Scanner(System.in);
		String inputString = scan.next();

		// キーボードからの入力をchar配列に変換
		char[] inputCharArray =inputString.toCharArray();

		// 桁数チェック
		if (!checkDigit(inputCharArray)){
			// ダメだった場合
			ShowMessage(1);
			System.exit(1);
		}

		// 文字の種類チェック
		if (!checkCharKind(inputCharArray)){
			//ダメだった場合
			ShowMessage(2);
			System.exit(2);
		}

		// 結果表示

		// 入力値 String -> int
		int inputInt=Integer.parseInt(inputString);

		// 桁数を取得
		int digitLen=String.valueOf(inputInt).length();

		// 1文字目が-だったら桁数を一つ少なく
		if( inputCharArray[0]=='-'){
		digitLen--;
		}

		System.out.println("＊＊□数字チェック結果□＊＊");
		System.out.println("□ＡＬＬ ＮＵＭＢＥＲ！！\r\n");
 
		System.out.print("入力した文字列は" + inputInt);
		System.out.print("で桁数は" + digitLen + "です。\r\n");


	}

	/* メッセージを表示するだけのクソクラス*/
	private static void ShowMessage(int num){
		switch (num){
			case 0: // 最初のメッセージのやつ
				System.out.println("＊＊□数字チェックプログラム□＊＊");
				System.out.println("＊＊□整数を入力して下さい□□＊＊");
				break;

			case 1: // 桁数がおかしいとき
				System.out.println("＊＊□入力桁数が不正です！□□＊＊\r\n");
				break;

			case 2: // 文字の種類がおかしいとき
				System.out.println("＊＊□入力した文字が不正です！□□＊＊\r\n");
				break;
		}
	}

	/* 入力文字列の桁数が10桁以上かどうかを判断するだけのクソメソッド*/
	private static boolean checkDigit(char inputChar[]){
		// 最初の文字が"+" or "-" かどうか？
		if (inputChar[0]=='+' || inputChar[0]=='-'){
			// 最初の文字が+か-だった場合
			if (inputChar.length > 11){
				return false;
			} else {
				return true;
			}
		} else {
			if (inputChar.length > 10){
				return false;
			} else {
				return true;
			}
		}
	}

	/* 文字の種類をチェックするうううううう 
		 仕様見る限り、半角数字だけOKにすればよくね？*/
	private static boolean checkCharKind(char inputChar[]){

		//最初の1文字
		// HACK 糞みたいな書き方。 正規表現使えばもっときれいになるよね
		if (inputChar[0]=='+' || inputChar[0]=='-' || inputChar[0]=='0' ||  inputChar[0]=='1' || inputChar[0]=='2' || inputChar[0]=='3' || inputChar[0]=='4' || inputChar[0]=='5' || inputChar[0]=='6' || inputChar[0]=='7' || inputChar[0]=='8' || inputChar[0]=='9'){

			// 1文字目以降

			for (int charCount = 1; charCount < inputChar.length; charCount++){

				// HACK 糞みたいな書き方。 正規表現使えばもっときれいになるよね
				if (inputChar[charCount]=='0' ||  inputChar[charCount]=='1' || inputChar[charCount]=='2' || inputChar[charCount]=='3' || inputChar[charCount]=='4' || inputChar[charCount]=='5' || inputChar[charCount]=='6' || inputChar[charCount]=='7' || inputChar[charCount]=='8' || inputChar[charCount]=='9'){

				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
}
