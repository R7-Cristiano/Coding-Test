package Baekjoon;

import java.io.*;
import java.util.*;

//병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해라
public class beckjoon24060 {
    static int[] A; //입력배열
    static int[] temp; //병합 과정에서 임시로 사용될 배열
    static int count = 0; //저장 횟수 추정
    static int result = -1; //k번째 저장된 값을 저장
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);// 배열의 크기
        int K = Integer.parseInt(nums[1]); //병합 정렬의 저장 횟수
        //String 배열을 stream으로 변환 -> 스트림은 배열이나 컬렉션의 요소를 하나씩 처리할 수 있는 연속된 데이터의 흐름임.
        //.mapToInt-> 스트림의 각 요소를 변환하는 작업 수행
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        temp = new int[N];

        mergeSort(0,N-1,K);

        //K번째 값이 저장이 되지 않은 경우
        if(result == -1){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }
    public static void mergeSort(int left, int right, int K){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(left, mid, K); // 왼쪽 절반 정렬
            mergeSort(mid + 1, right, K); // 오른쪽 절반 정렬
            merge(left, mid, right, K); // 병합
        }
    }
    public static void merge(int left,int mid, int right,int K){
        int i = left; //왼쪽 배열 시작
        int j = mid+1; //오른쪽 배열 시작
        int t = 0; //임시 배열 인덱스

        // 두 부분 배열 병합
        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                temp[t++] = A[i++];
            } else {
                temp[t++] = A[j++];
            }
        }

        //왼쪽 배열 남은 부분 자리
        while(i <= mid){
            temp[t++] = A[i++];
        }
        //오른쪽 배열 남은 부분 자리
        while(j <= right){
            temp[t++] = A[j++];
        }
        //임시 배열을 원본 배열로 복사
        for(int k=0; k<t; k++){
            A[left+k] = temp[k];
            count++; //저장 횟수 증가
            if(count ==K){
                result = A[left+k]; // K번째 저장된 값 저장
                return;// 더 이상 작업하지 않음
            }
        }
    }
}
