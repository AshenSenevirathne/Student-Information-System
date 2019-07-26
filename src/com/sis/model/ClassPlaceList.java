/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.sis.model;

public class ClassPlaceList extends Student {
	private float avg;
	private float sum;
	private int totalSubject;

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	

	public int getTotalSubject() {
		return totalSubject;
	}

	public void setTotalSubject(int totalSubject) {
		this.totalSubject = totalSubject;
	}

	@Override
	public String toString() {
		return "ClassPlaceList [avg=" + avg + ", sum=" + sum + ", totalSubject=" + totalSubject + "]";
	}

	

}
