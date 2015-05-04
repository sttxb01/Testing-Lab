class Range
{
  private double start;
  private double stop;
  
  Range(double start, double stop)
  {
   if (start == stop)
   {
    start = 0.0;
    stop = 0.0;
   }
   else
   {
    start = Math.min(start,stop);
    stop = Math.max(start,stop);
   }
  }
  
  boolean contains(double value)
  {
////    if (value >= start + value < stop)
//    {
      return true;
//    }
//    
//    if else
//    {
//      return false;
//    }
//    
  }
  
//  double getWidth()
//  {
//    
//  }
//  
  double getMin()
  {
    return start;
  }
  
//  double getMax()
//  {
//    
//  }
//  
//  Range intersection(Range other)
//  {
//    
//  }
  
}