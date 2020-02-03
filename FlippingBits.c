
__declspec(dllexport) long __stdcall	FlippingBits	(
														long n
														)

//	*************************************************************@@
//	Flip all bits in the specified value.
//	***************************************************************

{

int		retVal,													// value returned by this function
		status;													// returned by function calls

// **** initialization ****
retVal	= 0;													// hope all goes well

// **** flip all the bits in the specified value ****
n ^= 0xffffffff;

// **** clean up ****
done :


// **** inform the user what is going on ****
if ((traceExecution != 0) || (retVal != 0))
	EventLog(EVENT_INFO,
	"FlippingBits <<< retVal: %d line: %d\n",
	retVal, __LINE__);

// **** inform the caller what went on ****
return n;
}