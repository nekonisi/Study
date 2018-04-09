package JavaChallnege;

import java.util.Scanner;

public class MakeBreadSystem {

	/**
	 * メイン処理
	 */
	public static void main(String args[]) {
		try (Scanner scan = new Scanner(System.in)) {
			int[] breadOrder = new int[2];

			System.out.println("注文するあんパンの個数を入力してください。");
			String inputValue = scan.next();

			if (!checkIntegerValue(inputValue)) {
				throw new Exception("フォーマットエラー: 整数値を入力してください");
			}

			breadOrder[0] = Integer.parseInt(inputValue);

			System.out.println("注文する食パンの個数を入力してください。");
			inputValue = scan.next();

			if (!checkIntegerValue(inputValue)) {
				throw new Exception("フォーマットエラー: 整数値を入力してください");
			}

			breadOrder[1] = Integer.parseInt(inputValue);

			SuperMarket superMarket = SuperMarket.getSuperMarketInstance();
			superMarket.order(breadOrder);

			System.out.println("在庫を表示");
			System.out.println(superMarket.getStock());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("パン作成システムを終了します。");
		}
	}

	/**
	 * @param value
	 * @return フォーマットチェックの成否
	 * 
	 */
	private static boolean checkIntegerValue(String value) {
		String pattern = "[0-9]+";
		return value.matches(pattern);
	}
}