import java.util.LinkedList;

public class FordFulkerson {
	
	
	public static boolean dfs( int b, int derdhje, int [][] A, int[] P ) {  // boolean[] visited
		
	
		LinkedList<Integer > que = new LinkedList<Integer >();
		 boolean[] visited = new boolean[A.length ];
		
		
		for ( int i = 0; i < visited.length ; i ++) { 
			visited[i ] = false ;
		}
		
		visited[b] = true ;
		P[ b ] = -1 ;
		
		 removeQue( visited,  que,  A, b, P );
		
		while(  que.size() != 0 ) {
			
			int t = que.poll();
			// visited[t] = true ;
			 removeQue( visited, que, A, t, P ) ;
			
		}
		
		
		return ( visited[ derdhje ] == true ) ;
	}
	
	
	public static void removeQue( boolean[] visited , LinkedList que, int [][] A, int b, int[] P  ) {
		
	int n = A.length ;
	
		for (int i = 0 ; i < n ; i++) {
			
			/*
			if( ( A[b][i] == 0 && A[i][b] != 0 )  ) {
				A[b][i] = A[i][b] ;
				
			 }
		*/
			if(  !visited[ i]  &&  !que.contains(i) &&   A[b][i] != 0 ) { 
				
					que.addLast( i) ;  
					visited[i] = true ;
					P[i] = b ;
				
			}
			
			
			
		}
	}
	
	
	public static int Fordfulkerson( int [][] A, int s, int t ) { // s -> burim t -> derdhje
		
		int [] P = new int [ A.length ] ;
		
		int maxflow = 0;
		int flow = Integer.MAX_VALUE ;
		
		while( dfs( s, t, A, P) ) {
		
			  flow = Integer.MAX_VALUE ;
			
			for ( int v = t ; v!=s ; v =P[v]) {
				int u =P[v] ;
				flow = Math.min( flow,  A[u][v]) ;
				
			}
			
			
			maxflow = maxflow + flow ;
		
			System.out.println( " "   );
			for ( int v = t ; v!= s; v=P[v]) {
				int u =P[v] ;
				
				  System.out.println( "A[" + u + "][ " + v + "] :  " + A[ u ][ v ]  );
				A[ u ][ v ] = A[ u ][ v ] - flow ;
				// A[ v ][ u ] = A[ v ][ u ] - flow ;
				A[ v ][ u ] = A[ v ][ u ] + flow ;
			}
			
		}
		
		
		return maxflow ;
		}
	
	
	
	
	public static void main(String[] args) {
		
		int [][] A = new int[][] { {0, 16, 13, 0, 0, 0}, 
            {0, 0, 10, 12, 0, 0}, 
            {0, 4, 0, 0, 14, 0}, 
            {0, 0, 9, 0, 0, 20}, 
            {0, 0, 0, 7, 0, 4}, 
            {0, 0, 0, 0, 0, 0} 
          }; 
		
		int burim = 0 ;
		int derdhje = 5 ;
		
		int maxFlow = Fordfulkerson(  A, burim, derdhje ) ;
		
		
		System.out.println( "\n" +maxFlow + "\n \n" );
		
		
		for( int i = 0 ; i < A.length ; i++ ) {
			for( int j = 0 ; j < A.length ; j++ ) {
				System.out.println( A[ i ][ j ] );
			}
			System.out.println( ""  );
			}
		}
		
	}

