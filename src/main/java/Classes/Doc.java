/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;

/**
 *
 * @author mac
 */
public class Doc {
    public int doclength;
    public HashMap<String, Integer> detail;
    public Doc(String str, int num, int length) {
	detail = new HashMap<String, Integer>();
	detail.put(str, num);
	doclength = length;
    }
}
