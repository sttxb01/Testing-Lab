class Average
{
  private double sum = 0.0;
  private int count = 0;
 
  public Average()
  {
    
  }
  
  public void addValue(double value)
  {
    sum += value;
    count += 1;
  }
  
  double getAverage()
  {
    if (count != 0)
    { 
      return sum / count;
    }
      return 0;
  }
  
  int getCount()
  {
    return count;
  }
}