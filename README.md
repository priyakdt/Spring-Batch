spring-batch---Reads Fixed length file and writes to database.
============
It reads  2,000,000 rows from a fixed length file and inserts them into the database. 
The entire process took around 1 minute and 10 seconds to execute. 
That is pretty good time for Java-based batch processing.
In all fairness I must point out that, this is relatively fast since, 
It skips the records if there are any duplicates and writes in to the database.


