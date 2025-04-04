class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       ArrayList<Integer> al = new ArrayList<>();
        int i =0;
        int j =0;
         while(i<m && j<n){
        if(nums1[i] <= nums2[j]){
            al.add(nums1[i]);
            i++;
        }else //if (nums2[j]<nums1[i])
        {
            al.add(nums2[j]);
            j++;
        }
         }
             
         while(i<m){    
        //else{
            //if(i>=m){
                al.add(nums1[i]);
                i++;
            }
            //else{
             while(j<n){
                al.add(nums2[j]);
                j++;
            }
        
         
        for(int k=0; k<al.size(); k++  ){
            nums1[k]= al.get(k);
        }
    }
}