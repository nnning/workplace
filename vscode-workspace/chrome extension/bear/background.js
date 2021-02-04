window.bears = {}
chrome.runtime.onMessage.addListener(function(request, sender, sendMessage) {
    bears[request.url] = request.count
})

chrome.browserAction.onClicked.addListener(function(tab){
    chrome.tabs.create({url: 'popup.html'})
}) 