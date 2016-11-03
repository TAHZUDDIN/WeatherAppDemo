package example.com.weatherapp.pojos;


public class WeatherClass
{
    Query query;

     public class Query
     {

         Results results;

         public class Results
         {

                Channel channel;
               public  class Channel
                {
                    Location location;
                    Wind wind;
                    Atmosphere atmosphere;
                    Item item;

                   public class Location
                    {
                        String city;
                        String country;

                        public String getCity() {
                            return city;
                        }

                        public String getCountry() {
                            return country;
                        }
                    }


                    public class Wind
                    {
                        String speed;

                        public String getSpeed() {
                            return speed;
                        }
                    }

                    public class Atmosphere
                    {
                        String humidity;
                        String pressure;

                        public String getHumidity() {
                            return humidity;
                        }

                        public String getPressure() {
                            return pressure;
                        }
                    }

                    public class Item
                    {

                        Condition condition;

                        public Condition getCondition() {
                            return condition;
                        }
                    }

                    public class Condition
                    {
                        String text,date ;

                        String temp;

                        public String getText() {
                            return text;
                        }

                        public String getDate() {
                            return date;
                        }

                        public String getTemp() {
                            return temp;
                        }
                    }


                    public Location getLocation() {
                        return location;
                    }

                    public Wind getWind() {
                        return wind;
                    }

                    public Atmosphere getAtmosphere() {
                        return atmosphere;
                    }

                    public Item getItem() {
                        return item;
                    }
                }

             public Channel getChannel() {
                 return channel;
             }
         }


         public Results getResults() {
             return results;
         }
     }

    public Query getQuery() {
        return query;
    }
}
