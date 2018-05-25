public static int [] selectionSort(int [] a){
  for(int i=0; i < a.length; i++){
    int minimum = i;
    for(int j = i+1; j < a.length; j++){
      if(a[j] < a[minimum]){ // will only enter here if we find a smaller value
        minimum = j;
      }
    }
    int temp = a[i];
    a[i] = a[minimum];
    a[minimum] = temp;
  }
  return a;
}
