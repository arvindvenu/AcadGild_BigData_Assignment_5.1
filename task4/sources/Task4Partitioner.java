package mapreduce.task4;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 
 * @author arvind
 * Used to specify the partitioning of keys from the mapper to the reducer 
 */
public class Task4Partitioner extends Partitioner<Text, IntWritable>{

	/**
	 * Characters can be compared like numbers. So, first converting the key to lowercase
	 * and extracting the first character of the companyName. After doing that, fitting them in ranges using if- elseif 
	 */
	@Override
	public int getPartition(Text companyName, IntWritable numUnitsSold, int numReducers) {
		// TODO Auto-generated method stub
		String companyNameLowercase = companyName.toString().toLowerCase();
		char firstChar = companyNameLowercase.charAt(0);
		if(firstChar >='a' && firstChar <='f') {
			return 0;
		} else if(firstChar >='g' && firstChar <='l') {
			return 1;
		} else if(firstChar >='m' && firstChar <='r') {
			return 2;
		} else {
			return 3;
		}
	}

}
