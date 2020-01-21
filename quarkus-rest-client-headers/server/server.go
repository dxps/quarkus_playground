package main

import (
	"fmt"
	"net/http"
	"sort"
)

func handler(w http.ResponseWriter, r *http.Request) {

	var keys []string
	for k := range r.Header {
		keys = append(keys, k)
	}
	sort.Strings(keys)

	_, _ = fmt.Println("\nRequest Headers on path", r.URL.Path[1:])
	for _, k := range keys {
		_, _ = fmt.Printf("   %-32s : %s\n", k, r.Header[k])
	}
	w.Header().Set("Content-Type", "application/json")
	_, _ = fmt.Fprintln(w, "{ \"response\": \"Hi\" }")

}

func main() {
	http.HandleFunc("/", handler)
	fmt.Println(">>> Starting the Web Server and listening on :8081")
	_ = http.ListenAndServe(":8081", nil)
}
