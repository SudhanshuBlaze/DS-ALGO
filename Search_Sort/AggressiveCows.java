import java.util.*;class AggressiveCows{	public static void main(String args[]){		int stalls[]={1,2,4,7,8,9}; //always dist elements present		int cows=3;		System.out.println(maximiseMinDist(stalls,cows,stalls.length));	}	static int maximiseMinDist(int stalls[], int cows, int N){		Arrays.sort(stalls);		//our search space lies between [low,high]		int low=1;  //min value of dist between stalls		int high=stalls[N-1]-stalls[0];  //max value of dist between stalls, our ans lies between this		int res=-1;		while(low<= high){			int mid=(low + high)>>1;			if(canPlace(stalls, mid, cows)){				res=mid;  //save the ans				low=mid+1; //look for higher values			}			else{				//shrink the search space-> traditional BinarySearch				high=mid-1;			}		}		return res;	}	static boolean canPlace(int stalls[],int minDist, int cows){		//one cow always placed at first position, count=1, because 1 cow already placed		int coord=stalls[0], count=1;		for(int i=1;i<stalls.length;i++){			if(stalls[i]-coord>=minDist){				coord=stalls[i];				count++;			}			if(count==cows)				return true;		}		return false;	}}