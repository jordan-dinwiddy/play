package cx.ath.nb12;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapOrderTest {

	@Test
	public void test() {
		
		Map<String, Object> myMap = new HashMap<String, Object>();
		
		for(int i = 0; i < 10; i++) {
			myMap.put(i+"", i+"");
		}
		
		for(String keyValue : myMap.keySet()) {
			System.out.println(keyValue);
		}
	}

}
