int __stdcall	TestFlippingBits	(
									void
									)

//	***************************************************************@@
//	- Test the FlippingBits function with a set of specified values.
//	*****************************************************************

{

static	long	values[]	=	{
								2147483647,
								1,
								0,
								4,

								123456,
								0,
								802743475,
								35601423
								};

int				retVal,											// value returned by this function
				status;											// returned by function calls

long			result;											// returned by function call

// **** initialization ****
retVal		= 0;												// hope all goes well

result		= (long)0L;											// for starters

// **** loop calling the FlippingBits function ****
for (int i = 0; i < sizeof(values) / sizeof(long); i++)
	{
	result = FlippingBits(values[i]);
	printf("TestFlippingBits <<< result: %lu\n", result);
	}

// **** clean up ****
done:

// **** inform the user what is going on ****
if ((traceExecution != 0) || (retVal != 0))
	EventLog(EVENT_INFO,
	"TestFlippingBits <<< retVal: %d line: %d\n",
	retVal, __LINE__);

// **** inform the caller what went on ****
return retVal;
}