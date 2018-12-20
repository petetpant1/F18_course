import java.util.*;
import java.util.regex.Pattern;


public class MyHw0{

	static class InfoClass{
		public Integer dividend;
		public ArrayList<Integer> Divisors; 		
		public HashMap<Integer,Integer> OccurencesMap;
		public int number_of_occurences;
		public int current_index;
	
		public InfoClass(Integer dividend){
			this.dividend = dividend;
			this.number_of_occurences = 1;
			this.current_index = 0;
			this.Divisors = new ArrayList<Integer>();
			this.OccurencesMap = new HashMap<Integer,Integer>();
		}

	};

	public static void main(String[] args) {
		Integer dividend,divisor,vector_index,divisor_occurence;
		String backslash = "|";
		String line;
		HashMap<Integer,InfoClass> InfoMap = new HashMap<Integer,InfoClass>();
		InfoClass info; 

		ArrayList<InfoClass> printing_array = new ArrayList<InfoClass>();


		Scanner s = new Scanner(System.in);

		while ( s.hasNextLine() == true ){
			line = s.nextLine();
			String[] parts = line.split(Pattern.quote(backslash) );

			dividend = Integer.parseInt(parts[0]);
			divisor = Integer.parseInt(parts[1]);

			info = InfoMap.get(dividend); 
			
			if ( info == null ){
				info = new InfoClass(dividend);
				info.Divisors.add(divisor);
				info.OccurencesMap.put(divisor, info.number_of_occurences );  		
				InfoMap.put(dividend, info);
			}else{
				info.Divisors.add(divisor);

				if ( info.OccurencesMap.get(divisor) == null ){
					info.number_of_occurences++;
					info.OccurencesMap.put(divisor, info.number_of_occurences );	
				}
			}
	
			printing_array.add(info);
			
		}	

		for ( int i = 0 ; i < printing_array.size() ; i++ ) {
			vector_index = printing_array.get(i).current_index++;
			divisor = printing_array.get(i).Divisors.get(vector_index);
			divisor_occurence = printing_array.get(i).OccurencesMap.get(divisor);
			System.out.println( printing_array.get(i).dividend+"|"+divisor+"["+divisor_occurence+" of "+printing_array.get(i).number_of_occurences+"]"  );
			
		}
		

		s.close();
	}


}
