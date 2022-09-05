import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution1797 {

    int timeToLive;
    Map<String, Integer> dict;

    public Solution1797(int timeToLive) {
        this.timeToLive = timeToLive;

        dict = new HashMap<String, Integer>();

    }

    public void generate(String tokenId, int currentTime) {


        dict.put(tokenId,timeToLive + currentTime);

    }

    public void renew(String tokenId, int currentTime) {

        popExp(currentTime);

        if (dict.get(tokenId) != null)
        {

            dict.put(tokenId, timeToLive +currentTime);

        }

    }


    public int countUnexpiredTokens(int currentTime) {
        popExp(currentTime);

        System.out.println(dict.size());

        return dict.size();

    }


    public void popExp(int currentTime)
    {
        Iterator itr = dict.entrySet().iterator();

        while(itr.hasNext())
        {

            Map.Entry ME = (Map.Entry) itr.next();

            if ((int) ME.getValue() <= currentTime )
            {
                itr.remove();
            }


        }

    }

    public static void main(String[] args)
    {

        Solution1797 x = new Solution1797(5);

        x.renew("aaa",1);
        x.generate("aaa",2);
        x.countUnexpiredTokens(6);
        x.generate("bbb",7);
        x.renew("aaa",8);
        x.renew("bbb",10);
        x.countUnexpiredTokens(15);


    }

}
