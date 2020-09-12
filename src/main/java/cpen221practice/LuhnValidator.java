package cpen221practice;


class LuhnValidator {

    private String input;

    boolean isValid(String candidate)
    {
        input = candidate.replaceAll("\\s+", ""); //remove any whitespaces
        if(!input.matches("[\\d\\s]+")) //check if there's any non-digits/whitespace
        {
            return false;
        }
        if(input.length() < 2)
        {
            return false;
        }

        if(productSumSecondDigits(input) % 10 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    int productSumSecondDigits(String s)
    {
        int sum = 0;
        boolean isSecond = false;
        for(int i = s.length() - 1; i >= 0; --i)
        {
            if(isSecond)
            {
                if(2 * (s.charAt(i) - '0') > 9)
                {
                    sum += (2 * (s.charAt(i) - '0')) - 9;
                }
                else
                {
                    sum += (2 * (s.charAt(i) - '0'));
                }

            }
            else
            {
                sum += s.charAt(i) - '0';
            }
                isSecond = !isSecond;
        }
        System.out.println(sum);
        return sum;
    }
}
